---
name: commit
description:
  Commit staged and unstaged changes with a TEST-42: prefix and descriptive message
---

Commit all changes with a descriptive message prefixed with `TEST-42:`.

## Steps

1. Run `git status` to see what files have changed.
2. Run `git diff` (staged and unstaged) to understand what actually changed.
3. Stage all changed tracked files with `git add -u` (avoid `git add .` or `git add -A`).
4. Draft a concise, descriptive commit message summarizing the *why* or *what* of the change. Keep it under 72
   characters after the prefix.
5. Commit using the format:

```
TEST-42: <descriptive message>
```

Example: `TEST-42: Add JSON schema validation for posts endpoint`

Do **not** push. Do **not** amend existing commits. Do **not** skip hooks (`--no-verify`).
