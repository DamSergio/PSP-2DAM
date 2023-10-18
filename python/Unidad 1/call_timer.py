import subprocess

result = subprocess.run(["python", "timerr.py", "3"])

print(result.stderr)
print(result.returncode)