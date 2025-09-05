package kg.nurtelecom.design.app.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import androidx.recyclerview.widget.RecyclerView
import kg.nurtelecom.design.chili3.view.cells.RadioCellView
import kotlin.random.Random

class SelectorAdapter(
    var dataset: List<SampleRadioItem>,
    val selectData: (SampleRadioItem) -> Unit
) : RecyclerView.Adapter<DefaultCartViewVH>() {

    var selectedData: SampleRadioItem? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefaultCartViewVH {
        return DefaultCartViewVH.create(parent.context) { selectedData ->
            this.selectedData = selectedData
            this.selectData.invoke(selectedData)
        }
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: DefaultCartViewVH, position: Int) {
        holder.onBind(dataset[position])
    }
}

class DefaultCartViewVH(
    val view: View,
    private val onSelect: (SampleRadioItem) -> Unit
) : RecyclerView.ViewHolder(view) {

    fun onBind(data: SampleRadioItem) {
        (view as RadioCellView).apply {
            setTitle(data.title)
            setSubtitle(data.subtitle)
            setOnCheckListener { isChecked ->
                if (isChecked) onSelect.invoke(data)
            }
        }
    }

    companion object {
        fun create(context: Context, onSelect: (SampleRadioItem) -> Unit): DefaultCartViewVH {
            val view = RadioCellView(context = context, ).apply {
                layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
                setTitleTextAppearance(kg.nurtelecom.design.chili3.R.style.Chili_H16_Primary_Bold)
                setSubtitleTextAppearance(kg.nurtelecom.design.chili2.R.style.Chili_H9_Secondary)
            }
            return DefaultCartViewVH(view) { onSelect.invoke(it) }
        }
    }
}

data class SampleRadioItem(
    val title: String,
    val subtitle: String,
    val id: Int = Random.nextInt(1000)
)