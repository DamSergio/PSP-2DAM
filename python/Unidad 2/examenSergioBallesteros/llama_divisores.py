import subprocess

p = subprocess.run(["python", "divisores.py", "10"], capture_output = True, text = True)
print(p.stdout)