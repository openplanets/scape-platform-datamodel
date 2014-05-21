/*
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package eu.scape_project.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
*
* @author frank asseg
*
*/
@XmlRootElement(name="identifier",namespace="http://scape-project.eu/model")
public class Identifier {


	@XmlAttribute(name="type")
    protected final String type;
	@XmlElement(name="value",namespace="http://scape-project.eu/model")
    protected final String value;

    @SuppressWarnings("unused")
    private Identifier() {
        this.type = null;
        this.value = null;
    }

    public Identifier(String value) {
        super();
        this.type = "String";
        this.value = value;
    }

    public Identifier(String type, String value) {
        super();
        this.type = type;
        this.value = value;
    }


    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Identifier)) {
            return false;
        }
        Identifier that = (Identifier) o;
        if (type != null ? !type.equals(that.type) : that.type != null) {
            return false;
        }
        if (!value.equals(that.value)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
	public String toString() {
		return "Identifier [type=" + type + ", value=" + value + "]";
	}

}
