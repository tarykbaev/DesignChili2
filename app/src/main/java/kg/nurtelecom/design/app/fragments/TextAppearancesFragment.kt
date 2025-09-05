package kg.nurtelecom.design.app.fragments

import android.os.Bundle
import android.view.View
import kg.nurtelecom.design.app.MainActivity
import kg.nurtelecom.design.app.base.BaseFragment
import com.design2.app.databinding.FragmentTextAppearanceBinding

class TextAppearancesFragment : BaseFragment<FragmentTextAppearanceBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setUpHomeEnabled(true)
    }

    override fun inflateViewBinging(): FragmentTextAppearanceBinding {
        return FragmentTextAppearanceBinding.inflate(layoutInflater)
    }
}