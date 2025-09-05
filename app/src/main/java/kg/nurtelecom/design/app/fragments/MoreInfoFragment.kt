package kg.nurtelecom.design.app.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import kg.nurtelecom.design.app.MainActivity
import kg.nurtelecom.design.app.base.BaseFragment
import kg.nurtelecom.design.app.base.ViewInfo
import com.design2.app.databinding.FragmentMoreInfoBinding

class MoreInfoFragment : BaseFragment<FragmentMoreInfoBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setUpHomeEnabled(true)
        val info = arguments?.getSerializable(INFO) as? ViewInfo ?: ViewInfo()
        vb.title.text = info.title
        vb.content.text = info.content
    }

    override fun inflateViewBinging(): FragmentMoreInfoBinding {
        return FragmentMoreInfoBinding.inflate(layoutInflater)
    }

    companion object {

        const val INFO = "info"

        fun create(info: ViewInfo): MoreInfoFragment {
            return  MoreInfoFragment().apply {
                arguments = bundleOf(INFO to info)
            }
        }
    }
}