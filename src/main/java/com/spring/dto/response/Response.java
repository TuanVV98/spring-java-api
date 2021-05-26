package com.spring.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

/**
 * Class thuc hien phan hoi cuoi cung chung cho  API. 
 * 
 * @since 23/05/2021
 *
 * @param <T>
 */

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

	private T data;

	
}
