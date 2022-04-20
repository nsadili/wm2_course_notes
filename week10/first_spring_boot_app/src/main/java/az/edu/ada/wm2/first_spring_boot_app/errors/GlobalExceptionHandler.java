package az.edu.ada.wm2.first_spring_boot_app.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ModelAndView handleGeneralExceptions(Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/errors/bad_request");
        mv.addObject("exception", ex);
        return mv;
    }
}
