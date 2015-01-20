#Load Large Bitmaps Efficiently - Android

##Overview

This is an **Android** library used for loading bitmaps efficiently from local disk, If you have a big image on disk and want to load it in an **ImageView**, then you could use this library to load a sampled bitmap from this image. You could use this library to avoid the **OutOfMemoryError** Exception that occurs when you load high resolution images.

If you have an image with resolution 2048x1536, this would allocate about 12MB in memory to load a full image, you could use this library to load a smaller version of this image with a predefined height and width. This library will load a subsampled version for you. This will not destroy the aspect ratio of the image.

This library will load the image in its original orientation also by reading the **ExifInterface** of this image and rotate it appropriately.

##Components

1. **ImageLoaderLibrary**

##Code Example
This library could be used like this, just pass the path of the image, the required width and height and it will return back a subsampled bitmap of the image.

	ImageView mImageView = findViewById(R.id.mImageView);
	Bitmap mBitmap = ImageLoaderLibrary.loadImage("someImagePath", 512, 512);
	mImageView.setImageBitmap(mBitmap);
	
#Motivation
Consider yourself needs to load a high resolution image that would take more than 20MB in memory. Also consider that the image your are loading is displayed rotated. This library will load it efficiently and in its original orientation.

![First](https://lh4.googleusercontent.com/_s2b_3kIUlD4UWipKq8k8cZN_zqUIQdtrSgiJeOAvgFBYilw5SPD1cKNPRNXP6fydqExQA=w1896-h756)  ![Second](https://lh6.googleusercontent.com/ml0stvxXhF8DiPkqYMq_w--DcJ7ww0-mYWCzFUQyPwdCdMCYNMxI0qV_7i9Le07seVULOg=w1896-h756)
#Installation
To use this library, just pull or download and put it in your project. Do not forget to add your package name.

You will need the following class:

1. **ImageLoaderLibrary**

Then you could use the **loadImage** method to load the subsampled bitmap.

For help, please contact [support@inovaeg.com](support@inovaeg.com)

#API Reference

```
Class ImageLoaderLibrary{
	/**
	* Use this method to load subsampled bitmap of the image specified by the imagePath. The result bitmap will have the
	* original aspect ratio and the original orientation of the image.
	* @param imagePath the path of image to be loaded
	* @param reqWidth required width of the subsampled version
	* @param reqHeight required height of the subsampled version
	*
	* @return Bitmap returns the subsampled bitmap of the image
	*/
	public static Bitmap loadImage(String imagePath, int reqWidth, int reqHeight);
}
```

##Contributors list
1. [Inova Team](http://www.inovaeg.co/)
2. [Hossam M. Saad](http://eg.linkedin.com/in/hossammahmoud91)

##License
Copyright (C) 2015 Inova LLC. Licensed under the [Apache License](http://www.apache.org/licenses/LICENSE-2.0)
, Version 2.0 