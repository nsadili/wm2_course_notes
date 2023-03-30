package az.edu.ada.wm2.validationandexceptionhandlingdemo.exceptions;

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
        mv.setViewName("/errors/error_400");
        mv.addObject("exception", ex);
        return mv;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ModelAndView handleUserNotFoundExceptions(UserNotFoundException ex) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/errors/error_404");
        mv.addObject("exception", ex.getMessage());
        return mv;
    }
}
