
package sample;

import java.io.IOException;
import java.util.Set;
import java.util.regex.Pattern;

import org.junit.runner.JUnitCore;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

public class TestRunner {

	private void run() throws IOException {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
		scanner.addIncludeFilter(new RegexPatternTypeFilter(Pattern.compile(".*Test")));
		Set<BeanDefinition> components = scanner.findCandidateComponents(getClass().getPackage().getName());
		String[] names = components.stream().map(b -> b.getBeanClassName()).toArray(s -> new String[s]);
		JUnitCore.main(names);
	}

	public static void main(String[] args) throws IOException {
		new TestRunner().run();
	}

}
