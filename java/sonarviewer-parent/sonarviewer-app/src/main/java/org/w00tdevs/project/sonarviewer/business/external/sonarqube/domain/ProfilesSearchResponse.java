/*
*	     ___    wWw ()_()(o)__(o)  .-.         _      wWw  wWw    wWw oo_    
*	    (___)__ (O)_(O o)(__  __)c(O_O)c      /||_    (O)_ (O)    (O)/  _)-< 
*	    (O)(O)  / __)|^_\  (  ) ,'.---.`,      /o_)   / __)( \    / )\__ `.  
*	    /  _\  / (   |(_))  )( / /|_|_|\ \    / |(\  / (    \ \  / /    `. | 
*	    | |_))(  _)  |  /  (  )| \_____/ |    | | ))(  _)   /  \/  \    _| | 
*	    | |_)) \ \_  )|\\   )/ '. `---' .`    | |//  \ \_   \ `--' / ,-'   | 
*	    (.'-'   \__)(/  \) (     `-...-'      \__/    \__)   `-..-' (_..--'  
*
*		sonarviewer-app - org.alberto.project.sonarviewer.sonarqube.domain - ProfilesSearchResponse.java
* 		08-mar-2016 - Alberto
*/

package org.w00tdevs.project.sonarviewer.business.external.sonarqube.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The Class ProfilesSearchResponse.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "profiles"
})
public class ProfilesSearchResponse {

    /** The profiles. */
    @JsonProperty("profiles")
    private List<SonarQubeProfile> profiles = new ArrayList<SonarQubeProfile>();
    
    /** The additional properties. */
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Gets the profiles.
     *
     * @return the profiles
     */
    @JsonProperty("profiles")
    public List<SonarQubeProfile> getProfiles() {
        return profiles;
    }

    /**
     * Sets the profiles.
     *
     * @param profiles the new profiles
     */
    @JsonProperty("profiles")
    public void setProfiles(List<SonarQubeProfile> profiles) {
        this.profiles = profiles;
    }

    /**
     * Gets the additional properties.
     *
     * @return the additional properties
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Sets the additional property.
     *
     * @param name the name
     * @param value the value
     */
    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
