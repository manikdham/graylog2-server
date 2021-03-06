/**
 * Copyright 2013 Lennart Koopmann <lennart@torch.sh>
 *
 * This file is part of Graylog2.
 *
 * Graylog2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog2.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.graylog2.rest.documentation.generator;

import org.graylog2.Core;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.fail;

/**
 * @author Lennart Koopmann <lennart@torch.sh>
 */
public class GeneratorTest {

    @Test
    public void testGenerateOverview() throws Exception {
        Generator generator = new Generator("org.graylog2.rest.resources");
        Map<String, Object> result = generator.generateOverview();

        assertEquals(Core.GRAYLOG2_VERSION, result.get("apiVersion"));
        assertEquals(Generator.EMULATED_SWAGGER_VERSION, result.get("swaggerVersion"));

        assertNotNull(result.get("apis"));
        assertTrue(((List) result.get("apis")).size() > 0);
    }

    @Test
    public void testGenerateForRoute() throws Exception {
        Generator generator = new Generator("org.graylog2.rest.resources");
        Map<String, Object> result = generator.generateForRoute("/system", "http://localhost:12900/");
    }

}
