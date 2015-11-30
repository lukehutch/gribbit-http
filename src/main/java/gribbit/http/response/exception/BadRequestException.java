/**
 * This file is part of the Gribbit Web Framework.
 * 
 *     https://github.com/lukehutch/gribbit
 * 
 * @author Luke Hutchison
 * 
 * --
 * 
 * @license Apache 2.0 
 * 
 * Copyright 2015 Luke Hutchison
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
package gribbit.http.response.exception;

import io.netty.handler.codec.http.HttpResponseStatus;

/**
 * This exception is thrown when user-supplied data in the request is invalid.
 */
public class BadRequestException extends LightweightResponseException {
    String msg;

    public BadRequestException() {
        super(HttpResponseStatus.BAD_REQUEST);
    }

    public BadRequestException(String msg) {
        this();
        this.msg = msg;
    }

    @Override
    protected String getResponseMessage() {
        return msg == null ? super.getResponseMessage() : super.getResponseMessage() + " -- " + msg;
    }
}