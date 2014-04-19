/**
 *  Copyright 2012-2014 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mapstruct.ap.model.assignment;

import java.util.List;
import org.mapstruct.ap.model.Assignment;
import org.mapstruct.ap.model.common.Type;

/**
 * Decorates an assignment as local variable.
 *
 * @author Sjaak Derksen
 */
public class LocalVarWrapper extends AssignmentWrapper {

    private final List<Type> exceptionTypesToExclude;

    public LocalVarWrapper( Assignment decoratedAssignment, List<Type> exceptionTypesToExclude ) {
        super( decoratedAssignment );
        this.exceptionTypesToExclude = exceptionTypesToExclude;
    }

    @Override
    public List<Type> getExceptionTypes() {
        List<Type> result = super.getExceptionTypes();
        for (Type exceptionTypeToExclude : exceptionTypesToExclude) {
            result.remove( exceptionTypeToExclude );
        }
        return result;
    }
}