package kg.nurtelecom.design.app.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.text.parseAsHtml
import kg.nurtelecom.design.app.MainActivity
import com.design2.app.R
import kg.nurtelecom.design.app.base.BaseFragment
import com.design2.app.databinding.FragmentDividerBinding

class DividerFragment : BaseFragment<FragmentDividerBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setUpHomeEnabled(true)

        vb.divider2.apply {
            setEndIcon(R.drawable.chili_ic_switcher)
            setEndIconClickListener {
                Toast.makeText(context, "Switch!", Toast.LENGTH_SHORT).show()
            }
            setActionClickListener {
                Toast.makeText(context, "Action", Toast.LENGTH_SHORT).show()
            }
        }
        vb.divider1.setActionClickListener {
            Toast.makeText(context, "Action", Toast.LENGTH_SHORT).show()
        }

        vb.divider5.apply {
            setTitle("100 000,00 <u>c</u></span>".parseAsHtml())
            setEndContainerPaddingEnd(kg.nurtelecom.design.chili2.R.dimen.padding_44dp)
        }

    }

    override fun inflateViewBinging(): FragmentDividerBinding {
        return FragmentDividerBinding.inflate(layoutInflater)
    }

}