/* 
 * Copyright 2007 Luke Daley
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
package gldapo.directory
import org.springframework.ldap.core.support.LdapContextSource

class GldapoContextSource extends LdapContextSource
{	
	public static final PROPS = ["url", "urls", "base", "userDn", "password"]
	
	String getBaseDN()
	{
		return this.base?.toString()
	}
	
	static newInstance(Map config)
	{
		def c = new GldapoContextSource()
		PROPS.each { if (config.containsKey(it)) c."$it" = config."$it" }
		c.afterPropertiesSet()
		return c
	}
}