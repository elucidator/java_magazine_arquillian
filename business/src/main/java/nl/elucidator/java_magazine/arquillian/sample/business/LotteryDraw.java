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

import nl.elucidator.java_magazine.arquillian.sample.model.User;

import javax.inject.Inject;

/**
 * Class nl.elucidator.java_magazine.arquillian.sample.business.LotteryDraw.
 */
public class LotteryDraw {

    @Inject
    private WinningNumberGenerator generator;
    private static final int ADULT_AGE = 21;

    public boolean isLucky(final User user, final int lotteryNumber) {
        return generator.draw() == lotteryNumber && isAdult(user);
    }

    private boolean isAdult(final User user) {
        return user.getAge() >= ADULT_AGE;
    }
}
