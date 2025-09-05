package kg.nurtelecom.design.app.fragments

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kg.nurtelecom.design.app.MainActivity
import com.design2.app.R
import kg.nurtelecom.design.app.base.BaseFragment
import com.design2.app.databinding.FragmentSnackbarsBinding
import kg.nurtelecom.design.chili2.extensions.showInfinitiveLoaderSnackbar
import kg.nurtelecom.design.chili2.extensions.showSimpleSnackbar
import kg.nurtelecom.design.chili2.extensions.showTimerActionBeforeSuccessCnackbar
import kg.nurtelecom.design.chili2.view.snackbar.ChiliSnackBar

class SnackbarFragment : BaseFragment<FragmentSnackbarsBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setUpHomeEnabled(true)
        vb.loadSnackbar.setOnClickListener {
            (requireActivity() as AppCompatActivity).showInfinitiveLoaderSnackbar(vb.root, "Snackbar meesage")
        }
        vb.timerActionSnackbar.setOnClickListener {
            (requireActivity() as AppCompatActivity).showTimerActionBeforeSuccessCnackbar(vb.root, "Tiner message bla bla bla", "onSuccess", "click", {}, {}, 5000)
        }

        vb.simple.setOnClickListener {
            (requireActivity() as AppCompatActivity).showSimpleSnackbar(vb.root, "Hello")
        }
        vb.customWarining.setOnClickListener {
            ChiliSnackBar.Builder(vb.root)
                .setSnackbarIcon(R.drawable.ic_cat)
                .setSnackbarDurationMills(2000)
                .setSnackbarMessage("Warning message")
                .build()
                .show()

        }
        vb.onTopGravity.setOnClickListener {
            ChiliSnackBar.Builder(vb.root)
                .setSnackbarIcon(R.drawable.chili_ic_orange_warning)
                .setSnackbarMessage("Похоже пропал интернет. \nПроверьте интернет-соединение")
                .setSnackbarDurationMills(2000)
                .setGravity(Gravity.TOP)
                .build()
                .show()
        }
    }

    override fun inflateViewBinging(): FragmentSnackbarsBinding {
        return FragmentSnackbarsBinding.inflate(layoutInflater)
    }

}