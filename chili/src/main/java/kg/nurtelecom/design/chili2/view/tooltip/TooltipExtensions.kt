package kg.nurtelecom.design.chili2.view.tooltip

import android.content.Context
import android.view.View
import androidx.annotation.DimenRes
import kg.nurtelecom.design.chili2.R

fun Context.showTooltipView(
    anchorView: View,
    title: String,
    subtitle: String,
    onClick: (TooltipView) -> Unit = {},
    onDismiss: (TooltipView) -> Unit = {},
    onCloseClick: (TooltipView) -> Unit = {},
    onShow : (TooltipView) -> Unit = {},
    gravity: Int = TooltipView.GRAVITY_BOTTOM,
    arrowAlign: Int = TooltipView.ALIGN_START,
    @DimenRes marginRes: Int = R.dimen.padding_0dp
) {
    createTooltipView(
        anchorView = anchorView,
        title = title,
        subtitle = subtitle,
        onClick = onClick,
        onDismiss = onDismiss,
        onCloseClick = onCloseClick,
        onShow = onShow,
        gravity = gravity,
        arrowAlign = arrowAlign,
        marginRes = marginRes
    ).show()
}

fun Context.createTooltipView(
    anchorView: View,
    title: String,
    subtitle: String,
    onClick: (TooltipView) -> Unit = {},
    onDismiss: (TooltipView) -> Unit = {},
    onCloseClick: (TooltipView) -> Unit = {},
    onShow : (TooltipView) -> Unit = {},
    onSkip: (TooltipView) -> Unit = {},
    gravity: Int = TooltipView.GRAVITY_BOTTOM,
    arrowAlign: Int = TooltipView.ALIGN_START,
    @DimenRes marginRes: Int = R.dimen.padding_0dp
): TooltipView {
    return TooltipView.Builder(this)
        .anchorView(anchorView)
        .title(title)
        .subtitle(subtitle)
        .gravity(gravity)
        .arrowAlign(arrowAlign)
        .margin(marginRes)
        .onClickListener(object : TooltipView.OnClickListener {
            override fun onClick(tooltipView: TooltipView) { onClick(tooltipView) }
        })
        .onDismissListener(object : TooltipView.OnDismissListener {
            override fun onDismiss(tooltipView: TooltipView) { onDismiss(tooltipView) }
        })
        .onCloseBtnListener(object : TooltipView.OnCloseBtnListener {
            override fun onClose(tooltipView: TooltipView) { onCloseClick(tooltipView) }
        })
        .onShowListener(object : TooltipView.OnShowListener {
            override fun onShow(tooltipView: TooltipView) { onShow(tooltipView) }
        })
        .onSkipListener(object : TooltipView.OnSkipListener {
            override fun onSkip(tooltipView: TooltipView) { onSkip(tooltipView) }
        })
        .build()
}


