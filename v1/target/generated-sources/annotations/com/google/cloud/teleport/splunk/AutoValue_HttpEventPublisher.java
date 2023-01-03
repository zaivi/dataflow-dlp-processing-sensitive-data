package com.google.cloud.teleport.splunk;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.apache.v2.ApacheHttpTransport;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_HttpEventPublisher extends HttpEventPublisher {

  private final ApacheHttpTransport transport;

  private final HttpRequestFactory requestFactory;

  private final GenericUrl genericUrl;

  private final String token;

  private final byte[] rootCaCertificate;

  private final Integer maxElapsedMillis;

  private final Boolean disableCertificateValidation;

  private final Boolean enableGzipHttpCompression;

  private AutoValue_HttpEventPublisher(
      ApacheHttpTransport transport,
      HttpRequestFactory requestFactory,
      GenericUrl genericUrl,
      String token,
      @Nullable byte[] rootCaCertificate,
      @Nullable Integer maxElapsedMillis,
      Boolean disableCertificateValidation,
      Boolean enableGzipHttpCompression) {
    this.transport = transport;
    this.requestFactory = requestFactory;
    this.genericUrl = genericUrl;
    this.token = token;
    this.rootCaCertificate = rootCaCertificate;
    this.maxElapsedMillis = maxElapsedMillis;
    this.disableCertificateValidation = disableCertificateValidation;
    this.enableGzipHttpCompression = enableGzipHttpCompression;
  }

  @Override
  ApacheHttpTransport transport() {
    return transport;
  }

  @Override
  HttpRequestFactory requestFactory() {
    return requestFactory;
  }

  @Override
  GenericUrl genericUrl() {
    return genericUrl;
  }

  @Override
  String token() {
    return token;
  }

  @Nullable
  @Override
  byte[] rootCaCertificate() {
    return rootCaCertificate;
  }

  @Nullable
  @Override
  Integer maxElapsedMillis() {
    return maxElapsedMillis;
  }

  @Override
  Boolean disableCertificateValidation() {
    return disableCertificateValidation;
  }

  @Override
  Boolean enableGzipHttpCompression() {
    return enableGzipHttpCompression;
  }

  @Override
  public String toString() {
    return "HttpEventPublisher{"
        + "transport=" + transport + ", "
        + "requestFactory=" + requestFactory + ", "
        + "genericUrl=" + genericUrl + ", "
        + "token=" + token + ", "
        + "rootCaCertificate=" + Arrays.toString(rootCaCertificate) + ", "
        + "maxElapsedMillis=" + maxElapsedMillis + ", "
        + "disableCertificateValidation=" + disableCertificateValidation + ", "
        + "enableGzipHttpCompression=" + enableGzipHttpCompression
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HttpEventPublisher) {
      HttpEventPublisher that = (HttpEventPublisher) o;
      return this.transport.equals(that.transport())
          && this.requestFactory.equals(that.requestFactory())
          && this.genericUrl.equals(that.genericUrl())
          && this.token.equals(that.token())
          && Arrays.equals(this.rootCaCertificate, (that instanceof AutoValue_HttpEventPublisher) ? ((AutoValue_HttpEventPublisher) that).rootCaCertificate : that.rootCaCertificate())
          && (this.maxElapsedMillis == null ? that.maxElapsedMillis() == null : this.maxElapsedMillis.equals(that.maxElapsedMillis()))
          && this.disableCertificateValidation.equals(that.disableCertificateValidation())
          && this.enableGzipHttpCompression.equals(that.enableGzipHttpCompression());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= transport.hashCode();
    h$ *= 1000003;
    h$ ^= requestFactory.hashCode();
    h$ *= 1000003;
    h$ ^= genericUrl.hashCode();
    h$ *= 1000003;
    h$ ^= token.hashCode();
    h$ *= 1000003;
    h$ ^= Arrays.hashCode(rootCaCertificate);
    h$ *= 1000003;
    h$ ^= (maxElapsedMillis == null) ? 0 : maxElapsedMillis.hashCode();
    h$ *= 1000003;
    h$ ^= disableCertificateValidation.hashCode();
    h$ *= 1000003;
    h$ ^= enableGzipHttpCompression.hashCode();
    return h$;
  }

  static final class Builder extends HttpEventPublisher.Builder {
    private ApacheHttpTransport transport;
    private HttpRequestFactory requestFactory;
    private GenericUrl genericUrl;
    private String token;
    private byte[] rootCaCertificate;
    private Integer maxElapsedMillis;
    private Boolean disableCertificateValidation;
    private Boolean enableGzipHttpCompression;
    Builder() {
    }
    @Override
    HttpEventPublisher.Builder setTransport(ApacheHttpTransport transport) {
      if (transport == null) {
        throw new NullPointerException("Null transport");
      }
      this.transport = transport;
      return this;
    }
    @Override
    ApacheHttpTransport transport() {
      if (transport == null) {
        throw new IllegalStateException("Property \"transport\" has not been set");
      }
      return transport;
    }
    @Override
    HttpEventPublisher.Builder setRequestFactory(HttpRequestFactory requestFactory) {
      if (requestFactory == null) {
        throw new NullPointerException("Null requestFactory");
      }
      this.requestFactory = requestFactory;
      return this;
    }
    @Override
    HttpEventPublisher.Builder setGenericUrl(GenericUrl genericUrl) {
      if (genericUrl == null) {
        throw new NullPointerException("Null genericUrl");
      }
      this.genericUrl = genericUrl;
      return this;
    }
    @Override
    GenericUrl genericUrl() {
      if (genericUrl == null) {
        throw new IllegalStateException("Property \"genericUrl\" has not been set");
      }
      return genericUrl;
    }
    @Override
    HttpEventPublisher.Builder setToken(String token) {
      if (token == null) {
        throw new NullPointerException("Null token");
      }
      this.token = token;
      return this;
    }
    @Override
    String token() {
      if (token == null) {
        throw new IllegalStateException("Property \"token\" has not been set");
      }
      return token;
    }
    @Override
    HttpEventPublisher.Builder setRootCaCertificate(byte[] rootCaCertificate) {
      this.rootCaCertificate = rootCaCertificate;
      return this;
    }
    @Override
    @Nullable byte[] rootCaCertificate() {
      return rootCaCertificate;
    }
    @Override
    HttpEventPublisher.Builder setMaxElapsedMillis(Integer maxElapsedMillis) {
      this.maxElapsedMillis = maxElapsedMillis;
      return this;
    }
    @Override
    @Nullable Integer maxElapsedMillis() {
      return maxElapsedMillis;
    }
    @Override
    HttpEventPublisher.Builder setDisableCertificateValidation(Boolean disableCertificateValidation) {
      if (disableCertificateValidation == null) {
        throw new NullPointerException("Null disableCertificateValidation");
      }
      this.disableCertificateValidation = disableCertificateValidation;
      return this;
    }
    @Override
    Boolean disableCertificateValidation() {
      if (disableCertificateValidation == null) {
        throw new IllegalStateException("Property \"disableCertificateValidation\" has not been set");
      }
      return disableCertificateValidation;
    }
    @Override
    HttpEventPublisher.Builder setEnableGzipHttpCompression(Boolean enableGzipHttpCompression) {
      if (enableGzipHttpCompression == null) {
        throw new NullPointerException("Null enableGzipHttpCompression");
      }
      this.enableGzipHttpCompression = enableGzipHttpCompression;
      return this;
    }
    @Override
    HttpEventPublisher autoBuild() {
      String missing = "";
      if (this.transport == null) {
        missing += " transport";
      }
      if (this.requestFactory == null) {
        missing += " requestFactory";
      }
      if (this.genericUrl == null) {
        missing += " genericUrl";
      }
      if (this.token == null) {
        missing += " token";
      }
      if (this.disableCertificateValidation == null) {
        missing += " disableCertificateValidation";
      }
      if (this.enableGzipHttpCompression == null) {
        missing += " enableGzipHttpCompression";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_HttpEventPublisher(
          this.transport,
          this.requestFactory,
          this.genericUrl,
          this.token,
          this.rootCaCertificate,
          this.maxElapsedMillis,
          this.disableCertificateValidation,
          this.enableGzipHttpCompression);
    }
  }

}
