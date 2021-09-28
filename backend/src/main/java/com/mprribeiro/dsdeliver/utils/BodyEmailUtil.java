package com.mprribeiro.dsdeliver.utils;


import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.core.io.DefaultResourceLoader;

public class BodyEmailUtil {

	public static String getOrderConfirmationBody(String clientName, String orderNumber) {
		
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("clientName", clientName);
		valuesMap.put("orderNumber", orderNumber);
		
		StringSubstitutor sub = new StringSubstitutor(valuesMap);
		Optional<String> optionalMailBody = getMailTemplate("order_confirmation.html");
		return sub.replace(optionalMailBody.get());
	}

	private static Optional<String> getMailTemplate(String resourceName) {
		String result = null;
		if(StringUtils.isNotBlank(resourceName)) {
			var mailTemplateResource = new DefaultResourceLoader().getResource("classpath:mails/" + resourceName);
			if (mailTemplateResource.exists()) {
				try {
					try (var mailtemplateInputStream = mailTemplateResource.getInputStream()) {
						result = IOUtils.toString(mailtemplateInputStream, StandardCharsets.UTF_8);
					}
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
		return Optional.ofNullable(result);
	}
}
