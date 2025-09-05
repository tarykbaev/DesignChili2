package kg.nurtelecom.design.app.fragments

import android.os.Bundle
import android.view.View
import kg.nurtelecom.design.app.MainActivity
import kg.nurtelecom.design.app.base.BaseFragment
import com.design2.app.databinding.FragmentOverlaysBinding
import kg.nurtelecom.design.chili2.view.camera_overlays.ForeignPassportOverlay
import kg.nurtelecom.design.chili2.view.camera_overlays.PassportCardOverlay
import kg.nurtelecom.design.chili2.view.camera_overlays.RectangleOverlay

class OverlaysFragment : BaseFragment<FragmentOverlaysBinding>() {

    override fun inflateViewBinging(): FragmentOverlaysBinding {
        return FragmentOverlaysBinding.inflate(layoutInflater)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vb.btnPassport.setOnClickListener {
            (requireContext() as MainActivity).openFragment(
                OverlayFragment(
                    PassportCardOverlay(requireContext()).apply {
                        setHeaderText("Фото оборотной\n стороны паспорта")
                        setTitle("Проверьте паспорт")
                        setDescription("Поместите паспорт в рамку \n и нажмите на кнопку «сфотографировать»")
                    }
                ))
        }
        vb.btnRectngle.setOnClickListener {
            (requireContext() as MainActivity).openFragment(
                OverlayFragment(
                    RectangleOverlay(requireContext()).apply {
                        setDescription("Поместите лицо и паспорт в рамку и сделайте фоeeто")
                    }
                ))
        }
        vb.btnForeignPassport.setOnClickListener {
            (requireContext() as MainActivity).openFragment(
                OverlayFragment(
                    ForeignPassportOverlay(requireContext()).apply {
                        setHeaderText("Фото оборотной\n стороны паспорта")
                    }
                ))
        }
    }
}