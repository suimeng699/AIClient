package com.suimeng.domain;

import java.util.List;

/**
 * 响应对象
 */
public class ChatResponse {
    /*
  "id": "8d55a6f4-5e04-4266-978f-d6b86941f382",
  "object": "chat.completion",
  "created": 1744709140,
  "model": "deepseek-chat",
  "choices": [{"index": 0,"message": {"role": "assistant","content": "Hello! How can I assist you today? 😊"},
               "logprobs": null,
               "finish_reason": "stop"
                }],
  "usage": {"prompt_tokens": 9,"completion_tokens": 11,"total_tokens": 20,"prompt_tokens_details": {"cached_tokens": 0},"prompt_cache_hit_tokens": 0,"prompt_cache_miss_tokens": 9},
  "system_fingerprint": "fp_3d5141a69a_prod0225"
     */
    private List<Choice> choices;

    public List<Choice> getChoices() {
        return choices;
    }

    @Override
    public String toString() {
        return choices.toArray().toString();
    }
}
