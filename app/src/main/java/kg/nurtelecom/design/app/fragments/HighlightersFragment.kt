package kg.nurtelecom.design.app.fragments

import kg.nurtelecom.design.app.base.BaseFragment
import com.design2.app.databinding.FragmentHighlighterviewBinding

class HighlightersFragment : BaseFragment<FragmentHighlighterviewBinding>() {

    override fun inflateViewBinging(): FragmentHighlighterviewBinding {
        return FragmentHighlighterviewBinding.inflate(layoutInflater)
    }

}