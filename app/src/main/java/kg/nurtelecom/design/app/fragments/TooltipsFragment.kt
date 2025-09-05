package kg.nurtelecom.design.app.fragments

import android.os.Bundle
import android.view.View
import kg.nurtelecom.design.app.MainActivity
import kg.nurtelecom.design.app.base.BaseFragment
import com.design2.app.databinding.FragmentTooltipsBinding
import kg.nurtelecom.design.chili2.view.tooltip.TooltipView
import kg.nurtelecom.design.chili2.view.tooltip.createTooltipView

class TooltipsFragment : BaseFragment<FragmentTooltipsBinding>() {

    private var tooltipView: TooltipView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setUpHomeEnabled(true)
        initTooltip()
        initButton()
    }

    private fun initTooltip() {
        tooltipView = requireContext().createTooltipView(
            anchorView = vb.inputField,
            title = "Получи бонус 10 ГБ! (22)",
            subtitle = "При пополнении баланса на 120 с (32)"
        )
    }

    private fun initButton() {
        with(vb.inputField) {
            setOnClickListener { tooltipView?.show() }
            performClick()
        }
    }

    override fun inflateViewBinging(): FragmentTooltipsBinding {
        return FragmentTooltipsBinding.inflate(layoutInflater)
    }
}