package TogicException;

import Utils.Println;

public class NoInPackageException extends Exception {

	public NoInPackageException(String msg){
		new Println("NoInPackageException:"+msg);
	}
}
