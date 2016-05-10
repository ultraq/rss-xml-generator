/* 
 * Copyright 2016, Emanuel Rabina (http://www.ultraq.net.nz/)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nz.net.ultraq.rss

import org.thymeleaf.context.IExpressionContext
import org.thymeleaf.expression.IExpressionObjectFactory

/**
 * Factory for generating the RSS expression object instance.
 * 
 * @author Emanuel Rabina
 */
class RssExpressionObjectFactory implements IExpressionObjectFactory {

	static final String RSS_EXPRESSION_OBJECT_NAME = 'rss'

	final Set<String> allExpressionObjectNames = [
	  RSS_EXPRESSION_OBJECT_NAME
	]

	/**
	 * Returns an RSS expression object instance for the "rss" object name.
	 * 
	 * @param context
	 * @param expressionObjectName
	 * @return New RSS expression object for the "rss" name, or {@code null} for
	 *         anything else.
	 */
	@Override
	Object buildObject(IExpressionContext context, String expressionObjectName) {

		return expressionObjectName == RSS_EXPRESSION_OBJECT_NAME ? new RssExpressionObject() : null
	}

	/**
	 * Returns that the instance is cacheable for the "rss" name.
	 * 
	 * @param expressionObjectName
	 * @return {@code true} for the "rss" name.
	 */
	@Override
	boolean isCacheable(String expressionObjectName) {

		return expressionObjectName == RSS_EXPRESSION_OBJECT_NAME
	}
}
