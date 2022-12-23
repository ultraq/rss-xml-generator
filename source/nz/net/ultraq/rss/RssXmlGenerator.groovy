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

import nz.net.ultraq.rss.model.Channel
import nz.net.ultraq.thymeleaf.ifnotnulldialect.IfNotNullDialect

import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver

/**
 * Class to generate an RSS XML document using a Thymeleaf template.
 * 
 * @author Emanuel Rabina
 */
class RssXmlGenerator {

	private static final String DATE_FORMAT_RFC822  = 'EEE, dd MMM yyyy HH:mm:ss Z'

	private final TemplateEngine templateEngine

	/**
	 * Initialize a new Thymeleaf template engine for the generator.
	 */
	RssXmlGenerator() {

		templateEngine = new TemplateEngine(
			templateResolver: new ClassLoaderTemplateResolver(
				templateMode:      'XML',
				prefix:            'nz/net/ultraq/rss/',
				characterEncoding: 'UTF-8'
			),
			additionalDialects: [
				new IfNotNullDialect(),
				new RssDialect()
			]
		)
	}

	/**
	 * Generate an RSS XML document for the given channel.
	 * 
	 * @param channel RSS channel information.
	 * @param writer  Output stream to write the XML document to.
	 */
	void generate(Channel channel, Writer writer) {

		templateEngine.process('Template.xml', new Context(
			variables: [
				DATE_FORMAT_RFC822: DATE_FORMAT_RFC822,
				channel: channel
			]
		), writer)
	}
}
