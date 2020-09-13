package pl.kostrzynski.speechrecognitiontool.error;

import com.detectlanguage.errors.APIError;

@SuppressWarnings("serial")
public class ApiErrorHandler extends APIError {

    public ApiErrorHandler(String message, int code) {
        super(message, code);
        System.out.println(message);
        System.out.println(code);
    }


}
