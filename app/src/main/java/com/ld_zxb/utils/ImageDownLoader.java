package com.ld_zxb.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import com.ld_zxb.R;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;

public class ImageDownLoader extends BaseImageDownloader{
	public ImageDownLoader(Context context) {
		super(context);

	}
	protected InputStream getStreamFromOtherSource(String imageUri, Object extra) {
		BitmapDrawable drawable = (BitmapDrawable) context.getResources()
				.getDrawable(R.drawable.top_img_loadings);
		Bitmap bitmap = drawable.getBitmap();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		bitmap.compress(CompressFormat.PNG, 0, os);
		return new ByteArrayInputStream(os.toByteArray());
	}


}
