package com.example;

import io.micronaut.core.order.Ordered;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.OncePerRequestHttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;
import org.reactivestreams.Publisher;

@Filter("/*")
public class ProxyFilter extends OncePerRequestHttpServerFilter {
  @Override
  public int getOrder() {
    return Ordered.LOWEST_PRECEDENCE;
  }

  @Override
  protected Publisher<MutableHttpResponse<?>> doFilterOnce(
      HttpRequest<?> request, ServerFilterChain chain) {
    request.mutate();
    return chain.proceed(request);
  }
}
