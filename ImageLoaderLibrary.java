package com.cody.cody.view.lib;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;

public class ImageLoaderLibrary {
	
	/**
	* Use this method to load subsampled bitmap of the image specified by the imagePath. The result bitmap will have 
    * the original aspect ratio and the original orientation of the image.
	* @param imagePath the path of image to be loaded
	* @param reqWidth required width of the subsampled version
	* @param reqHeight required height of the subsampled version
	*
	* @return Bitmap returns the subsampled bitmap of the image
	*/
	public static Bitmap loadImage(String imagePath, int reqWidth, int reqHeight){
		float imageViewWidth = reqWidth;
		float imageViewHeight = reqHeight;
		

		BitmapFactory.Options bmOptions = new BitmapFactory.Options();
		bmOptions.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(imagePath, bmOptions);
		int photoW = bmOptions.outWidth;
		int photoH = bmOptions.outHeight;

		float scaleFactor;
		scaleFactor = Math.max(photoW / imageViewWidth, photoH/ imageViewHeight);


		bmOptions.inJustDecodeBounds = false;
		bmOptions.inSampleSize = (int) Math.ceil(scaleFactor);


		bmOptions.inPurgeable = true;
		Bitmap bitmap = BitmapFactory.decodeFile(imagePath, bmOptions);

		try {
			ExifInterface exif = new ExifInterface(imagePath);
			int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
			Matrix matrix = new Matrix();
			if (orientation == ExifInterface.ORIENTATION_ROTATE_90) {
				matrix.postRotate(90);
			} else if (orientation == ExifInterface.ORIENTATION_ROTATE_180) {
				matrix.postRotate(180);
			} else if (orientation == ExifInterface.ORIENTATION_ROTATE_270) {
				matrix.postRotate(270);
			}
			bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
		} catch (Exception e) {
			
		}
		return bitmap;
	}
}
