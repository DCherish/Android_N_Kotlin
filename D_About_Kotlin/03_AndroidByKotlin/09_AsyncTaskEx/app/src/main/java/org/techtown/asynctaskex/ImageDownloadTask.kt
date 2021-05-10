package org.techtown.asynctaskex

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import java.lang.Exception
import java.net.URL

class ImageDownloadTask(
    val context: Context,
    val rootLayout: LinearLayout,
    val progressBar: ProgressBar,
    val tvMesaage: TextView
) : AsyncTask<String, Int, ArrayList<Bitmap>>() {

    // 전처리
    override fun onPreExecute() {
        progressBar.progress = 0
        tvMesaage.text = "Download started..."
        super.onPreExecute()
    }

    // 백그라운드
    override fun doInBackground(vararg params: String?): ArrayList<Bitmap> {
        val list = ArrayList<Bitmap>()

        for (i in params.indices) {
            val urlOfImage = URL(params[i])

            try{
                val inputStream = urlOfImage.openStream()
                list.add(BitmapFactory.decodeStream(inputStream))
            } catch (e: Exception) {
                e.printStackTrace()
            }

            publishProgress(((i + 1) / params.size.toFloat() * 100).toInt())

            if (isCancelled) break
        }
        return list
    }

    override fun onProgressUpdate(vararg values: Int?) {
        progressBar.progress = values[0]!!
        tvMesaage.text = "Download....${values[0]}%"
        super.onProgressUpdate(*values)
    }

    override fun onCancelled() {
        tvMesaage.text = "AsyncTask Stopped"
        super.onCancelled()
    }

    override fun onPostExecute(result: ArrayList<Bitmap>?) {
        tvMesaage.text = "Complete"
        for (bitmap in result!!) {
            rootLayout.addView(newImage(bitmap))
        }
        super.onPostExecute(result)
    }

    private fun newImage(bitmap: Bitmap): ImageView {
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, 300)

        val imageView = ImageView(context)
        imageView.layoutParams = params
        imageView.setImageBitmap(bitmap)
        imageView.setPadding(10, 10, 10, 10)

        return imageView
    }
}
