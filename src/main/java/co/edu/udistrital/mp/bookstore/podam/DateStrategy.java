/*
MIT License

Copyright (c) 2025 Universidad Distrital

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package co.edu.udistrital.mp.bookstore.podam;

import java.lang.annotation.Annotation;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import uk.co.jemos.podam.common.AttributeStrategy;

public class DateStrategy implements AttributeStrategy<Date> {
	Random r = new Random();

	public Date getValue() {
		Calendar c = Calendar.getInstance();
		int maxYear = 9999;
		c.set(Calendar.YEAR,
				r.nextInt(maxYear - c.getActualMinimum(Calendar.YEAR) + 1) + c.getActualMinimum(Calendar.YEAR));
		c.set(Calendar.DAY_OF_YEAR,
				r.nextInt(c.getActualMaximum(Calendar.DAY_OF_YEAR) - c.getActualMinimum(Calendar.DAY_OF_YEAR) + 1)
						+ c.getActualMinimum(Calendar.DAY_OF_YEAR));
		c.set(Calendar.HOUR_OF_DAY, c.getActualMinimum(Calendar.HOUR_OF_DAY));
		c.set(Calendar.MINUTE, c.getActualMinimum(Calendar.MINUTE));
		c.set(Calendar.SECOND, c.getActualMinimum(Calendar.SECOND));
		c.set(Calendar.MILLISECOND, c.getActualMinimum(Calendar.MILLISECOND));
		return c.getTime();
	}

	@Override
	public Date getValue(Class<?> attrType, List<Annotation> attrAnnotations) {
		return null;
	}
}
