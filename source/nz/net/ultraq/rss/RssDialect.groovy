/* 
 * Copyright 2015, Emanuel Rabina (http://www.ultraq.net.nz/)
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

import org.thymeleaf.dialect.AbstractDialect
import org.thymeleaf.dialect.IExpressionObjectDialect
import org.thymeleaf.expression.IExpressionObjectFactory

/**
 * Dialect to add the RSS expression object for use in the RSS template.
 * 
 * @author Emanuel Rabina
 */
class RssDialect extends AbstractDialect implements IExpressionObjectDialect {

	static final String DIALECT_PREFIX = 'RSS XML Generator'

	/**
	 * Constructor, initializes this dialect.
	 */
	RssDialect() {

		super(DIALECT_PREFIX)
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	IExpressionObjectFactory getExpressionObjectFactory() {

		return new RssExpressionObjectFactory()
	}
}
