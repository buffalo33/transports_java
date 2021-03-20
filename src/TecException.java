package tec;

public class TecException extends Exception {
    public TecException(){
	super();
    }
    public TecException(String message){
	super(message);
    }
    public TecException(Throwable cause){
	super(cause);
    }
}
