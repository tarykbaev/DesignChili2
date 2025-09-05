package kg.nurtelecom.design.chili2.view.stories.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import kg.nurtelecom.design.chili2.view.stories.ChilliStoryBlock
import kg.nurtelecom.design.chili2.view.stories.ChilliStoryFragment
import kg.nurtelecom.design.chili2.view.stories.StoryClickListener
import kg.nurtelecom.design.chili2.view.stories.StoryMoveListener
import kg.nurtelecom.design.chili2.view.stories.StoryOnFinishListener

class ChilliStoryPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val fragments = ArrayList<ChilliStoryFragment>()

    fun createViewPager(stories: List<ChilliStoryBlock>, onMoveListener: StoryMoveListener?, onFinishListener: StoryOnFinishListener?, onStoryClickListener: StoryClickListener? = null) {
        fragments.clear()
        stories.forEach {
            addFragment(ChilliStoryFragment.newInstance(it, onMoveListener, onFinishListener, onStoryClickListener))
        }
    }

    fun addFragment(fragment: ChilliStoryFragment) {
        fragments.add(fragment)
    }

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

    fun getFragmentByPosition(position: Int) = fragments[position]
}
