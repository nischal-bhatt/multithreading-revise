
public class SequentialProcessing {

	public static void main(String[] args)
	{
		System.out.println("hello world");
		System.out.println("hello world2");
		System.out.println("hello world3");
		downloadImage();
		showImages();
	}

	private static void showImages() {
		System.out.println("showing images");
		
	}

	private static void downloadImage() {
        System.out.println("downloading images");		
	}
}
