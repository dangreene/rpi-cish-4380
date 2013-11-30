/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cish4380.groupproject.utility;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.PeriodType;
import org.springframework.stereotype.Component;

/**
 *
 * @author Dan
 */
@Component
public class ApplicationPerformanceCounter implements PerformanceCounter{
    private DateTime startTime; 
   
    @Override
    public void start() {
        this.startTime = DateTime.now();
    }
    
    @Override
    public String getDuration() {
        return new Duration(startTime,DateTime.now()).toPeriod(PeriodType.millis()).toString();
    }
}
