/*
 * Copyright 2019 Ververica GmbH.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ververica.statefun.flink.core.common;

import java.util.Objects;
import java.util.concurrent.Executor;
import org.apache.flink.streaming.api.operators.MailboxExecutor;

public final class MailboxExecutorFacade implements Executor {
  private final MailboxExecutor executor;
  private final String name;

  public MailboxExecutorFacade(MailboxExecutor executor, String name) {
    this.executor = Objects.requireNonNull(executor);
    this.name = Objects.requireNonNull(name);
  }

  @Override
  public void execute(Runnable command) {
    executor.execute(command::run, name);
  }
}
