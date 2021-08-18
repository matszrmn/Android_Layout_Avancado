package br.com.moduloavancado.util;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.appcompat.content.res.AppCompatResources;

import br.com.moduloavancado.model.Travel;

import static br.com.moduloavancado.util.DefaultConstants.DRAWABLE;

public class DrawableUtil {

    public static Drawable getDrawable(Travel travel, Context context) {
        int imgId = context.getResources().getIdentifier(travel.getImgSrc(), DRAWABLE, context.getPackageName());
        return AppCompatResources.getDrawable(context, imgId);
    }
}
