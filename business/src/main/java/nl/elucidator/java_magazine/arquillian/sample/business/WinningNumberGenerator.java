package nl.elucidator.java_magazine.arquillian.sample.business;/*
 * Copyright (c) 2015 Pieter van der Meer (pieter_at_elucidator_nl)
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

/**
 * Class nl.elucidator.java_magazine.arquillian.sample.business.WinningNumberGenerator.
 */
public class WinningNumberGenerator {
    static double SALT = Math.random()*1E4;

    public int draw(){
        return (int)(Math.random() * SALT);
    }
}
