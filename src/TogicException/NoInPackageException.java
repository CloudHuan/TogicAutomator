package TogicException;

public class NoInPackageException extends Exception {

	public NoInPackageException(String msg){
		super(msg);
		System.exit(-1);
	}
}
