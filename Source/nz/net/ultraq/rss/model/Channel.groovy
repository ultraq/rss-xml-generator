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

package nz.net.ultraq.rss.model

import groovy.transform.Immutable

/**
 * Representation of the largely static parts of an RSS channel.
 * 
 * @author Emanuel Rabina
 */
@Immutable
class Channel {

	// Required fields
	String title
	String link
	String description

	// Fields from other namespaces
	String atomSelfLink

	// Optional fields
	String language
	int ttl
	Image image
}
