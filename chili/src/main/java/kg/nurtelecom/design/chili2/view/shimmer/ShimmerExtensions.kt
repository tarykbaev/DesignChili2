package kg.nurtelecom.design.chili2.view.shimmer

import android.view.ViewGroup
import androidx.core.view.children
import kg.nurtelecom.design.chili2.extensions.gone
import kg.nurtelecom.design.chili2.extensions.invisible
import kg.nurtelecom.design.chili2.extensions.visible

fun ViewGroup.startGroupShimmering() {
    (this as? ShimmeringView)?.startShimmering()
    children.forEach { (it as? ViewGroup)?.startGroupShimmering() }
}

fun ViewGroup.stopGroupShimmering() {
    (this as? ShimmeringView)?.stopShimmering()
    children.forEach { (it as? ViewGroup)?.stopGroupShimmering() }
}

fun ShimmeringView.startShimmering() {
    (this as? ViewGroup)?.apply {
        isClickable = false
        isFocusable = false
    }
    onStartShimmer()
    getShimmeringViewsPair().forEach {
        it.key.invisible()
        it.value?.apply {
            visible()
            startShimmer()
        }
    }
}

fun ShimmeringView.stopShimmering(isSurfaceClickable: Boolean = true) {
    (this as? ViewGroup)?.apply {
        isClickable = isSurfaceClickable
        isFocusable = isSurfaceClickable
    }
    onStopShimmer()
    getShimmeringViewsPair().forEach {
        it.key.visible()
        it.value?.apply {
            stopShimmer()
            gone()
        }
    }
}