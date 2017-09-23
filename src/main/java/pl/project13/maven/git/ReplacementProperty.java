/*
 * This file is part of git-commit-id-plugin by Konrad 'ktoso' Malawski <konrad.malawski@java.pl>
 *
 * git-commit-id-plugin is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * git-commit-id-plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with git-commit-id-plugin.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.project13.maven.git;

import java.util.ArrayList;
import java.util.List;

import org.apache.maven.plugins.annotations.Parameter;

/**
 * @since 2.2.3
 */
public class ReplacementProperty {
  /**
   * Defines if a replacement should only be applied to a single property.
   * If left empty the replacement will be performed on all generated properties.
   */
  @Parameter
  private String property;

  /**
   * @since 2.2.4
   * Defines an additional output property suffix.
   * Note: 
   * this will only be *appended* to the current property key
   * (e.g. when the property is set to 'sample' the property
   * 'git.branch' will be transformed to 'git.branch.sample')
   * 
   * Be advised that you might want to adjust your include
   * or exclude filters which be applied after the regex validation.
   */
  @Parameter
  private String propertyOutputSuffix;

  /**
   * Token to replace.
   * This may or may not be a regular expression.
   */
  @Parameter(required = true)
  private String token;

  /**
   * Value to replace token with.
   * The text to be written over any found tokens. 
   * You can also reference grouped regex matches made in the token here by $1, $2, etc.
   */
  @Parameter(required = true)
  private String value;

  /**
   * Indicates if the token should be located with regular expressions. 
   */
  @Parameter(defaultValue = "true")
  private boolean regex = true;

  /**
   * @since 2.2.4
   * Provides the ability to perform certain string transformations before regex evaluation or after.
   */
  @Parameter
  private List<TransformationRule> transformationRules = new ArrayList<>();

  public ReplacementProperty(){}

  public ReplacementProperty(String property, String propertyOutputSuffix, String token, String value, boolean regex, List<TransformationRule> transformationRules) {
    this.property = property;
    this.propertyOutputSuffix = propertyOutputSuffix;
    this.token = token;
    this.value = value;
    this.regex = regex;
    this.transformationRules = transformationRules;
  }

  public String getProperty() {
    return property;
  }

  public void setProperty(String property) {
    this.property = property;
  }

  public String getPropertyOutputSuffix() {
    return propertyOutputSuffix;
  }

  public void setPropertyOutputSuffix(String propertyOutputSuffix) {
    this.propertyOutputSuffix = propertyOutputSuffix;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public boolean isRegex() {
    return regex;
  }

  public void setRegex(boolean regex) {
    this.regex = regex;
  }

  public List<TransformationRule> getTransformationRules() {
    return transformationRules;
  }

  public void setTransformationRules(List<TransformationRule> transformationRules) {
    this.transformationRules = transformationRules;
  }
}
