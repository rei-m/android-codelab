package com.example.android.findme

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dialog = createInstructionsDialog()
        dialog.show()
    }

    private fun createInstructionsDialog(): Dialog {
        val builder = AlertDialog.Builder(this)
        builder.setIcon(R.drawable.android)
            .setTitle(R.string.instructions_title)
            .setMessage(R.string.instructions)
            .setPositiveButtonIcon(ContextCompat.getDrawable(this, android.R.drawable.ic_media_play))
        return builder.create()
    }
}

/*
In Android, Shader defines the color(s) or the texture with which the Paint object should draw (other than a bitmap).
Android defines several subclasses of Shader for Paint to use, such as BitmapShader, ComposeShader, LinearGradient, RadialGradient, SweepGradient.
A Shader defines the content for a Paint object which should be drawn. A subclass of Shader is installed in a Paint by calling paint.setShader(shader).
Alpha compositing is the process of compositing (or combining) a source image with a destination image to create the appearance of partial or full transparency. The amount of transparency is defined by the alpha channel.
BitmapShader draws a bitmap drawable as a texture. The bitmap can be repeated or mirrored by setting the TileMode mode.
The tiling mode, TileMode, defined in the Shader, specifies how the bitmap drawable is repeated in the X and Y directiona. Android provides three ways to repeat the bitmap drawable: REPEAT, CLAMP, MIRROR.
 */