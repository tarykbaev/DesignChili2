package kg.nurtelecom.design.app.fragments

import android.os.Bundle
import android.view.View
import kg.nurtelecom.design.app.base.BaseFragment
import com.design2.app.databinding.FragmentWithInputBinding
import kg.nurtelecom.design.chili2.extensions.setOnSingleClickListener

class FragmentWithInput(
    private val text: String?,
    private val onAction: (String) -> Unit
) : BaseFragment<FragmentWithInputBinding>() {

    override fun inflateViewBinging(): FragmentWithInputBinding =
        FragmentWithInputBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        with(vb) {
            inputView.apply {
                setText(text)
                setSimpleTextChangedListener {
                    btnAction.isEnabled = it.toString().isNotEmpty()
                }
            }
            btnAction.setOnSingleClickListener {
                val newName = inputView.getInputText()
                onAction.invoke(newName)
            }
        }
    }
}
