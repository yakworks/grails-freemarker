/*
* Copyright 2009-2011 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package grails.plugin.freemarker;

import java.util.Map;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import org.codehaus.groovy.grails.web.util.WebUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

/**
 * 
 * @author Jeff Brown
 *
 */
public class GrailsFreeMarkerView extends FreeMarkerView {

    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        model.put("flash", WebUtils.retrieveGrailsWebRequest().getAttributes().getFlashScope(request));
        super.exposeHelpers(model, request);
    }

	/**
	 * Ovverides the super so it does not check to see if the resource exists first
	 */
	// @Override
	// public boolean checkResource(Locale locale) throws Exception {
	// 	return true;
	// }
}