/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cish4380.groupproject.dataaccess;

import java.util.Iterator;
import org.cish4380.groupproject.domain.StudentSummaryResult;

/**
 *
 * @author Dan
 */
public interface StudentSummaryRepository {
    Iterator<StudentSummaryResult> getStudentSummaryResults();
}
