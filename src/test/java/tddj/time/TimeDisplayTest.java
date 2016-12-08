package tddj.time;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TimeDisplayTest {

    @InjectMocks
    TimeDisplay sut;

    @Mock
    TimeService timeService;

    protected Calendar getCalendar() {
        Calendar myTime = new GregorianCalendar();
        myTime.set(Calendar.HOUR_OF_DAY, 12);
        myTime.set(Calendar.MINUTE, 0);
        return myTime;
    }

    @Test
    public void testDisplayCurrentTime_At_Noon() {
        //Given
        when(timeService.getCalendar()).thenReturn(this.getCalendar());

        // When
        String result = sut.getCurrentTimeInFunnyWay();
        // verify direct output
        assertThat(result).isEqualTo("C'est l'heure du déjeuner");
    }
}