package br.com.alura.aluraviagens.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourcesUtil {
    @SuppressLint("UseCompatLoadingForDrawables")
    public static Drawable devolveDrawable(Context context, String drawableEmTexto) {
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(drawableEmTexto,
                "drawable",
                context.getPackageName());
        return resources.getDrawable(idDoDrawable);
    }

}
