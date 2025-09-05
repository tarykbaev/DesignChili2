package kg.nurtelecom.design.app.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.core.text.parseAsHtml
import kg.nurtelecom.design.app.MainActivity
import kg.nurtelecom.design.app.base.BaseFragment
import com.design2.app.databinding.FragmentAccountCardExamplesBinding
import kg.nurtelecom.design.app.extensions.setBankSyncState
import kg.nurtelecom.design.app.extensions.setFavoritePaymentAmountAvailableState
import kg.nurtelecom.design.app.extensions.setFavoritePaymentAmountUnavailableState
import kg.nurtelecom.design.app.extensions.setIdentificationInProcessState
import kg.nurtelecom.design.app.extensions.setNoFavoritePaymentAmountState
import kg.nurtelecom.design.app.extensions.setNonAuthorizedState
import kg.nurtelecom.design.app.extensions.setNonIdentifiedState
import kg.nurtelecom.design.chili2.view.shimmer.startGroupShimmering
import kg.nurtelecom.design.chili2.view.shimmer.stopGroupShimmering

class AccountCardsExamplesFragment : BaseFragment<FragmentAccountCardExamplesBinding>() {

    override fun inflateViewBinging(): FragmentAccountCardExamplesBinding {
        return FragmentAccountCardExamplesBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setUpHomeEnabled(true)

        vb.acv8.apply {
            setToggleIconState(isHiddenState = false)
            setSubtitle("1212 <u>c</u>".parseAsHtml())
            onToggleChange {
                println("toggle $it")
            }
            onMainContentClick {
                println("main click")
            }
            onActionButtonClick {
                println("action ")
            }
        }
        vb.acvDynamic.setFavoritePaymentAmountAvailableState(
            "Карта Visa",
            "•••• 1234",
            isToggleHiddenState = true,
            "1212 <u>c</u>".parseAsHtml()
        )

        Handler(Looper.getMainLooper()).postDelayed({
            vb.acvDynamic.setNonAuthorizedState(
                "Оплачивайте",
                "Более 2000 сервисов")
        },6000)

        Handler(Looper.getMainLooper()).postDelayed({
            vb.acvDynamic.setNonIdentifiedState("Пройдите \nИдентификацию")
        },3000)

        Handler(Looper.getMainLooper()).postDelayed({
            vb.acvDynamic.setFavoritePaymentAmountAvailableState(
                "Карта Visa",
                "•••• 1234",
                isToggleHiddenState = false,
                "1212 <u>c</u>".parseAsHtml()
            )
        },9000)

        Handler(Looper.getMainLooper()).postDelayed({
            vb.acvDynamic.setFavoritePaymentAmountUnavailableState(
                "Карта Visa Карта Visa \n Карта Visa Карта Visa ",
                "•••• 1234 \n•••• 1234",
                "Временно недоступен"
            )
        },12_000)

        Handler(Looper.getMainLooper()).postDelayed({
            vb.acvDynamic.setNoFavoritePaymentAmountState(
                "Избранный счет ",
                "Временно недоступен \nВременно недоступен"
            )
        },15_000)

        Handler(Looper.getMainLooper()).postDelayed({
            vb.acvDynamic.setIdentificationInProcessState("Ваша заявка \nв обработке")
        },18_000)

        Handler(Looper.getMainLooper()).postDelayed({
            vb.acvDynamic.setBankSyncState()
        },20_000)

        Handler(Looper.getMainLooper()).postDelayed({
            vb.acvDynamic.setNonAuthorizedState(
                "Оплачивайте",
                "Более 2000 сервисов")
        },22_000)
    }

    override fun startShimmering() {
        super.startShimmering()
        vb.root.startGroupShimmering()
    }

    override fun stopShimmering() {
        super.stopShimmering()
        vb.root.stopGroupShimmering()
    }
}